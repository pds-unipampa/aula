project(Baralho)

include_directories( src Testes) 
include(CPack)			

SET (Baralho_SRC src/embaralhar.c src/corta.c src/descarte.c src/retira.c)

add_library(Baralho SHARED ${Baralho_SRC})
add_executable(aplicacao  adivinha.c)

target_link_libraries(aplicacao Baralho)

install (
	 TARGETS Baralho #Nome do alvo que vai ser instalado (aqui é a biblioteca
	 #Onde os componentes de tempo de execução devem ser instaldos? (aqui indica uma pasta atual)
         RUNTIME DESTINATION bin
         #Pode ser usado para instalar apenas parte (componentes) do software
	 COMPONENT lib
	 #Onde as bibliotecas devem ser instaladas?
         LIBRARY DESTINATION lib 
         #Onde os demais arquivos devem ser instalados?
         ARCHIVE DESTINATION bin
)


install (#Nome do alvo que vai ser instalado (aqui é a applicação)
	 TARGETS aplicacao 
	 #Onde os componentes de tempo de execução devem ser instaldos? (aqui indica uma pasta atual)
         RUNTIME DESTINATION bin 
         #Pode ser usado para instalar apenas parte (componentes) do software
	 COMPONENT adivinha
	 #Onde as bibliotecas devem ser instaladas?
         LIBRARY DESTINATION lib 
         #Onde os demais arquivos devem ser instalados?
         ARCHIVE DESTINATION bin
)


ENABLE_TESTING()



add_executable(TestBaralho Testes/minunit.c)

target_link_libraries(TestBaralho Baralho)

add_test(TestBaralho TestBaralho)


