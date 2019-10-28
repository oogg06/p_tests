<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
    <xsl:template match="/">
        <html>
            <head>
                <title>Resultado</title>
            </head>
            <body>
                <p>Los nombres de proveedores de Londres y sus estados son los siguientes:</p>
                <ul>
                    <xsl:for-each select="//proveedor[ciudad='Londres']">
                        <li>
                            <xsl:value-of select="nombreprov"/> (Estado <xsl:value-of select="estado"/>)
                        </li>
                    </xsl:for-each>
                </ul>
                <p>Nombres y ciudades de partes azules y que además pesen igual o más de 13:</p>
                <ol>
                    <xsl:for-each select="//parte">
                        <xsl:if test="peso>=13">
                        <li>
                            <xsl:value-of select="nombreparte"/>, ciudad:<xsl:value-of select="ciudad"/>
                        </li>
                        </xsl:if>
                    </xsl:for-each>
                </ol>
            </body>
        </html>
    </xsl:template>
</xsl:stylesheet>