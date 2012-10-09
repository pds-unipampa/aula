project(Baralho)

include_directories( src Testes)
include(CPack)
			

SET (Baralho_SRC src/embaralhar.c src/corta.c src/descarte.c src/retira.c)

add_library(Baralho SHARED ${Baralho_SRC})
add_executable(moscao  moscao.c)

target_link_libraries(moscao Baralho)



install (
	 TARGETS Baralho 

         RUNTIME DESTINATION bin

	 COMPONENT bib
	
         LIBRARY DESTINATION lib 

         ARCHIVE DESTINATION bin
)


install (
	 TARGETS moscao
	 
         RUNTIME DESTINATION bin
      
	 COMPONENT aplicacao

         LIBRARY DESTINATION lib
        
         ARCHIVE DESTINATION bin
)



ENABLE_TESTING()


add_executable(TestBaralho Testes/minunit.c)

target_link_libraries(TestBaralho Baralho)

add_test(TestBaralho TestBaralho)


