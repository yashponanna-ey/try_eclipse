@echo off 
set message=%1
echo %message%>copyit.txt
PowerShell.exe -Command "& '%~dpn0.ps1'"
PAUSE