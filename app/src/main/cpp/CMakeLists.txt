cmake_minimum_required(VERSION 3.4.1)

set(CMAKE_CXX_FLAGS "${CMAKE_CXX_FLAGS} -std=c++11 -Wall -UNDEBUG")

add_library( native-lib
             SHARED
             native-lib.cpp)

add_library(hello-lib
            SHARED
            MyLog.h
            com_yunnex_ndkdemo_Hello.cpp
            )
# Include libraries needed for native-codec-jni lib
target_link_libraries(native-lib

                      android
                      log
                      )
target_link_libraries(hello-lib

                      android
                      log
                      )
