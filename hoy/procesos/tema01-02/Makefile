EXAMEN=Examen_1
MATERIA=ServiciosProcesos
#EXAMEN=Examen_$(NUMERO)
#MATERIA=Admon_SSOO
ASUNTO="$(EXAMEN) de $(MATERIA)"

EMAIL1=ogomezgarcia@gmail.com
EMAIL2=profesor.oscar.gomez@gmail.com
EMAIL3=o_gom_gar@hotmail.com

all: 
	pdflatex ClaseExamen.tex
	pdflatex ClaseExamen.tex
	evince ClaseExamen.pdf
comprimir:
	zip -r $(ASUNTO).zip *

examen: all
	cp ClaseExamen.pdf Examen.pdf;zip Examen.zip Examen.pdf fichero1.txt fichero2.txt fichero3.txt fichero4.txt	

enviar: all comprimir
	pdflatex ClaseExamen.tex
	
	icedove -compose "to=profesor.oscar.gomez@gmail.com,bcc='o_gom_gar@hotmail.com, ogomezgarcia@gmail.com',subject='$(ASUNTO)',body='Examen',attachment='`pwd`/$(ASUNTO).zip'"


clean:
	rm *.log *.aux *~ *.zip *.pdf
