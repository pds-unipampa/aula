project(baralho)

add_library(baralho SHARED baralho.c)

add_executable(App aplicacao.c)

target_link_libraries(App baralho)


