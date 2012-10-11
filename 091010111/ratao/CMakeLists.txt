project(Baralho)

include_directories( src Testes)
include(CPack)
			

SET (Baralho_SRC src/embaralhar.c src/corta.c src/descarte.c src/retira.c)

add_library(Baralho SHARED ${Baralho_SRC})
add_executable(ratao  ratao.c)

target_link_libraries(ratao Baralho)



install (
	 TARGETS Baralho 

         RUNTIME DESTINATION bin

	 COMPONENT bib
	
         LIBRARY DESTINATION lib 

         ARCHIVE DESTINATION bin
)


install (
	 TARGETS ratao
	 
         RUNTIME DESTINATION bin
      
	 COMPONENT aplicacao

         LIBRARY DESTINATION lib
        
         ARCHIVE DESTINATION bin
)



ENABLE_TESTING()


add_executable(TestBaralho Testes/minunit.c)

target_link_libraries(TestBaralho Baralho)

add_test(TestBaralho TestBaralho)


