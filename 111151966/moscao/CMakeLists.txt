project(Baralho)

include_directories( src Testes) 
			

SET (Baralho_SRC src/embaralhar.c src/corta.c src/descarte.c src/retira.c)

add_library(Baralho SHARED ${Baralho_SRC})
add_executable(moscao  moscao.c)

target_link_libraries(moscao Baralho)


ENABLE_TESTING()



add_executable(TestBaralho Testes/minunit.c)

target_link_libraries(TestBaralho Baralho)

add_test(TestBaralho TestBaralho)


