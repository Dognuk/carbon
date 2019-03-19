@ECHO OFF
windres info.rc -O coff -o info.res
C:\mingw\bin\gcc carbon.c -o ..\carbon.exe info.res
del /f carbon.exe info.res
ren shortcut.lnk Carbon.lnk
xcopy Carbon.lnk ..\
ren Carbon.lnk shortcut.lnk