EXAMEN=Examen_3
MATERIA=Marcas
#EXAMEN=Examen_$(NUMERO)
#MATERIA=Admon_SSOO
ASUNTO="$(EXAMEN) de $(MATERIA)"

EMAIL1=ogomezgarcia@gmail.com
EMAIL2=profesor.oscar.gomez@gmail.com
EMAIL3=o_gom_gar@hotmail.com

all: 
	pdflatex ClaseExamen2.tex
	pdflatex ClaseExamen2.tex
	evince ClaseExamen2.pdf
enviar:
	pdflatex ClaseExamen2.tex
	zip -r $(ASUNTO).zip *
	thunderbird -compose "to=profesor.oscar.gomez@gmail.com,bcc='o_gom_gar@hotmail.com, ogomezgarcia@gmail.com',subject='$(ASUNTO)',body='Examen',attachment='`pwd`/$(ASUNTO).zip'"


clean:
	rm *.log *.aux *~ *.zip *.pdf
