## Kill session on window:
* Run command-line as an Administrator. Then run the below mention command. type your port number in yourPortNumber
netstat -ano | findstr :yourPortNumber
example: netstat -ano | findstr :12370
* Then you execute this command after identify the PID.
taskkill /PID typeyourPIDhere /F
example: taskkill /PID 4724 /F

