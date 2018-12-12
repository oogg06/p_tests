<?xml version="1.0"?>
<xsl:stylesheet version="1.1" xmlns:xsl=
                "http://www.w3.org/1999/XSL/Transform">
        <xsl:template match="/">
                <html>
                        <head>
                                <title>Ejercicio 1</title>
                        </head>
                        <body>
                                <h1>Resultado</h1>
                                <table border="1">
									<xsl:for-each select="pedido/portatiles/portatil">
										<xsl:if test="peso &gt; 1500">
										<xsl:if test="precio &lt; 1900">
											<tr>
												<td>
													Peso:<xsl:value-of select="peso"/>
												</td>
												<td>
													RAM:<xsl:value-of select="ram"/>
												</td>
												<td>
													Precio<xsl:value-of select="precio"/>
												</td>
											</tr>
										</xsl:if>
										</xsl:if>
									</xsl:for-each>
								</table>
                        </body>
                </html>
        </xsl:template>
</xsl:stylesheet>