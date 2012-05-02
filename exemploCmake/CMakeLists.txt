project(Somador)

add_library(Soma SHARED arquivo.c)

add_executable(somador main.c)

target_link_libraries(somador Soma)



ENABLE_TESTING()

add_executable(somador_test test_main.c)

target_link_libraries(somador_test Soma)

add_test(TestSomador somador_test)



INCLUDE(CTest)
IF(BUILD_TESTING)
     SET(BUILDNAME "${BUILDNAME}" CACHE STRING "Outros testes")
     MARK_AS_ADVANCED(BUILDNAME)
ENDIF(BUILD_TESTING)
