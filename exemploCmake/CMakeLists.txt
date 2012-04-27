project(Somador)

add_library(Soma SHARED arquivo.c)

add_executable(somador main.c)

target_link_libraries(somador Soma)