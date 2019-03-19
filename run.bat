@ECHO OFF
START javaw -Djava.library.path=lib/natives/windows -jar target\carbon-0.1-alpha-jar-with-dependencies.jar
PAUSE