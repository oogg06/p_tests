<?xml version="1.0"?>
<xsl:stylesheet version="1.1" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
        <xsl:template match="/">
                <html>
                        <head>
                                <title>Ejercicio 1</title>
                        </head>
                        <body>
                                <h1>Resultado</h1>
                                <ol>
									<xsl:for-each select="pedido/tablets/tablet">
									<xsl:if test="caracteristicas/memoria &lt; 3">
										<li>
											Plataforma:<xsl:value-of select="plataforma"/>, 
											memoria:<xsl:value-of select="caracteristicas/memoria"/>GB,
											tamaño:<xsl:value-of select="caracteristicas/tamanio"/> pulgadas
										</li>
									</xsl:if>
									</xsl:for-each>
									
									
								</ol>
                                
                        </body>
                </html>
        </xsl:template>
</xsl:stylesheet>