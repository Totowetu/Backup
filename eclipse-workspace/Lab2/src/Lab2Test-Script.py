# Lab2Test-Script.py
# Created by Kelvin Ferreiras, modified by Vladimir Maksimovski, Dominick Harasimiuk
# Created on Nov. 16, 2017
# Last Modification on Jan. 31, 2019
# This program tests Lab2 for CSC-172

import subprocess
import glob
import os
import shlex

currentFile = 'Lab2Test-Script'#Name of script file
realPath = os.path.realpath(currentFile)
dirPath = os.path.dirname(realPath)

labTasks = ['Lab2']

# Take the name of all the .zip files into a list
submissions=glob.glob(dirPath+ "/*.zip")
test_case_directory = '/tests/'

in_file_extension = '.in'
out_file_extension = '.out'
ans_file_extension = '.ans'

#removes leftover files. FNULL serves to suppress output
FNULL = open(os.devnull, 'w')
subprocess.call('rm task*', shell=True, stdout=FNULL, stderr=subprocess.STDOUT)
subprocess.call('rm tests/task1/*.out', shell=True, stdout=FNULL, stderr=subprocess.STDOUT)

def runTestCase(src, test_in, test_out, test_ans):
    subprocess.call('java ' + src + ' < ' + '\"' + test_in + '\"' + '>' + '\"' + test_out + '\"', shell = True)

    # Compare compressed and the decompressed output file with the original file
    compare_command = 'diff -w -B ' + '\"' + test_ans + '\"' + ' ' + '\"' + test_out + '\"'
    compare_command = shlex.split(compare_command)
    compare_result = subprocess.Popen(compare_command, stdout=subprocess.PIPE).communicate()[0].rstrip().decode(
        'ascii')

    # If both files are identical, test case passed
    if compare_result == '':
        return True
    return False


def testSubmission(submission, labTasks, test_case_directory):
    subprocess.call(['unzip', '-o', ''+submission])

    # Extract student_id out of zip filename
    list_of_basename_elements = submission.split('_', 1)
    student_id = list_of_basename_elements[0]

    # Compile java files and run the test
    subprocess.call('javac *.java', shell = True)

    correctCases = 0
    totalCases = 0

    for task in labTasks:
        test_cases = glob.glob(dirPath + test_case_directory + task + '/*.in')
        for testCasePath in test_cases:
            testName = testCasePath[-5:-3]
            testHeader = testCasePath[:-3]

            in_file = testHeader + in_file_extension
            out_file = testHeader + out_file_extension
            ans_file = testHeader + ans_file_extension

            print('Currently testing ' + task + ', test case #' + testName)

            if runTestCase(task, in_file, out_file, ans_file) is True:
                print("SUCCESS!")
                correctCases += 1
            else:
                print("WRONG")

            totalCases += 1

    return student_id, correctCases, totalCases


# Iterate on every .zip file
for currentZip in submissions:
    # Extract file name from path
    name_of_file=os.path.basename(currentZip)

    student_id, correct, total = testSubmission(name_of_file, labTasks, test_case_directory)

    # Record grade in the TestResult text file
    gradebook = open('TestResult.txt', 'a')
    gradebook.write("NetId: "+ student_id + "    Evaluation Result: " + str(correct) + '/' + str(total) + "\n")
    gradebook.flush()
