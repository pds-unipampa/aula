project(Baralho)

SET (Baralho_SRC embaralhar.c corta.c descarte.c retira.c)

add_library(Baralho SHARED ${Baralho_SRC})
add_executable(aplicacao  aplicacao.c)

target_link_libraries(aplicacao Baralho)

