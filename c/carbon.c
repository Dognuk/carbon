#include <stdlib.h>

/*
Launch Carbon indirectly.
*/
int main() {

    system("start javaw -Djava.library.path=lib/natives/windows -jar target/carbon-0.1-alpha-jar-with-dependencies.jar");

    return 0;

}