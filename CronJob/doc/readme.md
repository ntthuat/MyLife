## Kill session on window:
* Run command-line as an Administrator. Then run the below mention command. type your port number in yourPortNumber
netstat -ano | findstr :yourPortNumber
example: netstat -ano | findstr :12370
* Then you execute this command after identify the PID.
taskkill /PID typeyourPIDhere /F
example: taskkill /PID 4724 /F

## Basic about cron job
* "0 0 * * * *" = the top of every hour of every day.
* "*/10 * * * * *" = every ten seconds.
* "0 0 8-10 * * *" = 8, 9 and 10 o'clock of every day.
* "0 0 8,10 * * *" = 8 and 10 o'clock of every day.
* "0 0/30 8-10 * * *" = 8:00, 8:30, 9:00, 9:30 and 10 o'clock every day.
* "0 0 9-17 * * MON-FRI" = on the hour nine-to-five weekdays
* "0 0 0 25 12 ?" = every Christmas Day at midnight

0 30 7 \* \* \? - cái này ví dụ chạy trong imx2banxico của Lợi. Chạy vào lúc 7.30AM

https://www.freeformatter.com/cron-expression-generator-quartz.html

