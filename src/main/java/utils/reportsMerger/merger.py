import codecs
from shutil import copy2

import sys

copy2("src/main/java/utils/reportsMerger/overview.html", "target/surefire-reports/overview.html")
for x in range(1, len(sys.argv)):
    startingFile = codecs.open("target/surefire-reports/overview.html", "r")
    startingLines = startingFile.readlines()
    startingLines.pop()
    startingLines.pop()
    startingFile.close()

    report = codecs.open("target/surefire-reports/" + sys.argv[x] + "/html/overview.html", "r")
    lines = report.readlines()
    write = False
    outfile = []

    for line in lines:
        if "<table" in line:
            write = True
        if write:
            outfile.append(line)

    report.close()

    endFile = codecs.open("target/surefire-reports/overview.html", "w", "utf-8")
    for line in startingLines:
        if x == 1:
            line = str.replace(line, 'href="', 'href="' + sys.argv[x] + '/html/')
        endFile.write(line)

    for line in outfile:
        line = str.replace(line, 'href="', 'href="' + sys.argv[x] + '/html/')
        endFile.write(line)

    endFile.close()
