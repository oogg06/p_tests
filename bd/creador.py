#!/usr/bin/python3

import sys
import os
from shutil import copy
from glob import glob



def get_nombres_modulo_validos():
    return next(os.walk('.'))[1]
    

def get_nombres_tema_validos(directorio):
    return next(os.walk(directorio))[1]

def get_nombre_modulo_parametro():
    nombres_modulo_validos=get_nombres_modulo_validos()
    try:
        nombre_modulo   =   sys.argv[1]
        if nombre_modulo not in nombres_modulo_validos:
            raise Exception
    except Exception:
        print("El primer argumento debe ser uno de estos")
        print("  ".join(nombres_modulo_validos))
        sys.exit(-1)
        
    return nombre_modulo


def get_nombre_tema_parametro(nombre_modulo):
    nombres_validos_temas   =   get_nombres_tema_validos(nombre_modulo)
    try:
        nombre_tema             =   sys.argv[2]
        if nombre_tema not in nombres_validos_temas:
            raise Exception
        return nombre_tema
    except Exception as e:
        print ("Para <"+nombre_modulo+"> el segundo argumento debe ser uno de estos")
        print("  ".join(nombres_validos_temas))
        sys.exit(-1)
    
    
def get_nombre_directorio_resultado_parametro():
    try:
        nombre_directorio       =   sys.argv[3]
    except:
        print("No has puesto nombre de directorio donde dejar el resultado")
        sys.exit(-1)
    return nombre_directorio


def get_subdirectorios_con_preguntas(directorio):
    return next(os.walk(directorio))[1]

def crear():
    
    nombre_modulo       =   get_nombre_modulo_parametro()
    nombre_tema         =   get_nombre_tema_parametro(nombre_modulo)
    nombre_directorio   =   get_nombre_directorio_resultado_parametro()
    
    try:
        print("Creando el directorio "+nombre_directorio+" ...")
        os.mkdir(nombre_directorio)
    except FileExistsError as e:
        print("¡¡¡Ya existe el directorio "+nombre_directorio+"!!!")
        print("Saliendo...")
        sys.exit(-1)
        
        
    
    subdirectorio_preguntas=os.path.join(nombre_modulo, nombre_tema)
    print("Buscando en:"+subdirectorio_preguntas)
    lista_subdirectorios_con_preguntas=get_subdirectorios_con_preguntas(subdirectorio_preguntas)
    
    
    for directorio_con_preguntas in lista_subdirectorios_con_preguntas:
        ruta=os.path.join(subdirectorio_preguntas, directorio_con_preguntas)
        print("Copiando desde "+ruta)
        ficheros=os.path.join(ruta, "*.*")
        lista_ficheros=glob(ficheros)
        for fichero in lista_ficheros:
            fichero_destino=os.path.join(nombre_directorio,fichero)
            print("Copiando "+fichero+" a " +nombre_directorio)
            copy(fichero, nombre_directorio)
    
if __name__ == '__main__':
    crear()
