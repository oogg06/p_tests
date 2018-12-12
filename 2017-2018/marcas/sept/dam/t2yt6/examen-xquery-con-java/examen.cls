\NeedsTeXFormat{LaTeX2e}
\ProvidesClass{examen}[2011/12/05]
\LoadClassWithOptions{article}[12pt]
\usepackage[activeacute, spanish]{babel}
\usepackage[latin1]{inputenc}
\usepackage{graphicx}
\usepackage{listings}
\usepackage{fancybox}
\usepackage[usenames]{color}
\usepackage{graphpap}
\definecolor{gris}{rgb}{0.5, 0.5, 0.5}
\definecolor{blanco}{rgb}{1,1,1}
\newcounter{numpregunta}
\setcounter{numpregunta}{1}


%%Esto es para los puntos
\newlength{\puntos}
\setlength{\puntos}{0pt}

\newcommand{\modulo}[1]{

									\begin{figure}
										\centering
											\includegraphics[width=0.1\textwidth]{examen-img/Escudo.png}
										\label{fig:Escudo}
									\end{figure}
									\vspace{.25cm}
								
								
								
								\begin{center}
								\ovalbox{Por favor, escribe tu nombre, apellidos y fecha \emph{en todas las hojas}.}
								\end{center}
								
								\vspace{.25cm}
								
								
					\begin{center}
					\textsc{{#1}}
					\end{center}
					\vspace{.5cm}
}

\newcommand{\tema}[1]{ 
\begin{center}
{#1}
\end{center}
}
\newcommand{\pregunta}[2]{

%Numero de la pregunta
\parbox{11cm}
{
	{\colorbox{gris}{\textcolor{blanco}{\arabic{numpregunta}}
	}
	}
	{\textit{(#2 p.)}} %Puntuacion
	#1 %Texto de la pregunta
	
	\vspace{0.35cm}
}

	
\addtocounter{numpregunta}{1}
\addtolength{\puntos}{#2pt}

}
\newcommand{\fin}{
\vfill

\addtocounter{numpregunta}{-1}

\begin{center}
\footnotesize{Este examen consta de \arabic{numpregunta} preguntas y la puntuación máxima es de \the\puntos.}
\end{center}

}
\pagestyle{empty}

\AtEndDocument{
	\fin
}