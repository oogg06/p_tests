<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
    <xsl:template match="/">
        <html>
            <head>
                <title>Examen</title>
            </head>
            <body>
                <table border="1">
                    <tr>
                        <th>Código de dispositivo</th>
                        <th>Memoria</th>
                    </tr>
                    <xsl:for-each select="//portatil">
                        <xsl:if test="ram/@unidad='GB' and ram>=4">
                            <tr>
                                <td>
                                    <xsl:value-of select="@codigo"/>
                                </td>
                                <td>
                                    <xsl:value-of select="ram"/>
                                    <xsl:value-of select="ram/@unidad"/>
                                </td>
                            </tr>
                        </xsl:if>
                    </xsl:for-each>
                </table>
            </body>
        </html>
    </xsl:template>
</xsl:stylesheet>