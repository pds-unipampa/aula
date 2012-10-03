project(Baralho)

include_directories( src Testes) 
			

SET (Baralho_SRC src/embaralhar.c src/corta.c src/descarte.c src/retira.c)

add_library(Baralho SHARED ${Baralho_SRC})
add_executable(hi-lo  aplicacao.c)

target_link_libraries(hi-lo Baralho)

#install (
#	 TARGETS Soma #Nome do alvo que vai ser instalado (aqui é a biblioteca
	 #Onde os componentes de tempo de execução devem ser instaldos? (aqui indica uma pasta atual)
 #        RUNTIME DESTINATION .
         #Pode ser usado para instalar apenas parte (componentes) do software
#	 COMPONENT somaLibs
	 #Onde as bibliotecas devem ser instaladas?
 #        LIBRARY DESTINATION . 
         #Onde os demais arquivos devem ser instalados?
  #       ARCHIVE DESTINATION .
#)


#install (#Nome do alvo que vai ser instalado (aqui é a applicação)
#	 TARGETS somador 
	 #Onde os componentes de tempo de execução devem ser instaldos? (aqui indica uma pasta atual)
 #        RUNTIME DESTINATION . 
         #Pode ser usado para instalar apenas parte (componentes) do software
#	 COMPONENT somaApps
	 #Onde as bibliotecas devem ser instaladas?
 #        LIBRARY DESTINATION . 
         #Onde os demais arquivos devem ser instalados?
  #       ARCHIVE DESTINATION .
#)


ENABLE_TESTING()



add_executable(TestBaralho Testes/minunit.c)

target_link_libraries(TestBaralho Baralho)

add_test(TestBaralho TestBaralho)


