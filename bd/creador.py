import sys
import os




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

def crear():
    
    nombre_modulo       =   get_nombre_modulo_parametro()
    nombre_tema         =   get_nombre_tema_parametro(nombre_modulo)
    nombre_directorio   =   get_nombre_directorio_resultado_parametro()
    
    
if __name__ == '__main__':
    crear()