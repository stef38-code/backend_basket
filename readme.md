### si Web server failed to start. Port 8080 was already in use.
```dos 
C:\WINDOWS\system32>netstat -ano | findstr *8080*

C:\WINDOWS\system32>netstat -ano | findstr 8080
  TCP    0.0.0.0:8080           0.0.0.0:0              LISTENING       1328
  TCP    [::]:8080              [::]:0                 LISTENING       1328

C:\WINDOWS\system32>taskkill /F /PID 1328
Opération réussie : le processus avec PID 1328 a été terminé.
```