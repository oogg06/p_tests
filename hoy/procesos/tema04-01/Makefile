EXAMEN=Examen_4
MATERIA=Marcas
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
enviar:
	pdflatex ClaseExamen.tex
	zip -r $(ASUNTO).zip *
	icedove -compose "to=profesor.oscar.gomez@gmail.com,bcc='o_gom_gar@hotmail.com, ogomezgarcia@gmail.com',subject='$(ASUNTO)',body='Examen',attachment='`pwd`/$(ASUNTO).zip'"


clean:
	rm *.log *.aux *~ *.zip
