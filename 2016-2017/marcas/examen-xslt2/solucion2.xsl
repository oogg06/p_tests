<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
    <xsl:template match="/">
        <pedido>
            <caros>
                <!--Este bucle recorre los portatiles-->
                <xsl:for-each select="pedido/portatiles/portatil">
                    <xsl:if test="precio &gt; 500">
                        <portatil>
                            <xsl:attribute name="precio">
                                <xsl:value-of select="precio"/>
                            </xsl:attribute>
                            <peso><xsl:value-of select="peso"/></peso>
                            <ram>
                                <xsl:attribute name="cantidad">
                                    <xsl:value-of select="ram"/>
                                </xsl:attribute>
                                <xsl:attribute name="unidad">
                                    <xsl:value-of select="ram/@unidad"/>
                                </xsl:attribute>
                            </ram>
                        </portatil>
                    </xsl:if>
                </xsl:for-each>
                <!--Este bucle recorre los tablets-->
                <xsl:for-each select="pedido/tablets/tablet">
                    <xsl:if test="precio &gt; 500">
                        <tablet>
                            <xsl:attribute name="precio">
                                <xsl:value-of select="precio"/>
                            </xsl:attribute>
                            <plataforma><xsl:value-of select="plataforma"/></plataforma>
                            <caracteristicas>
                                <memoria>
                                    <xsl:attribute name="cantidad">
                                        <xsl:value-of select="caracteristicas/memoria"/>
                                    </xsl:attribute>
                                    <xsl:attribute name="unidad">
                                        <xsl:value-of select="caracteristicas/memoria/@medida"/>
                                    </xsl:attribute>
                                </memoria>
                            </caracteristicas>
                        </tablet>
                    </xsl:if>
                </xsl:for-each>
            </caros>
            
            <baratos>
                <!--Este bucle recorre los portatiles-->
                <xsl:for-each select="pedido/portatiles/portatil">
                    <xsl:if test="precio &lt; 500">
                        <portatil>
                            <xsl:attribute name="precio">
                                <xsl:value-of select="precio"/>
                            </xsl:attribute>
                            <peso><xsl:value-of select="peso"/></peso>
                            <ram>
                                <xsl:attribute name="cantidad">
                                    <xsl:value-of select="ram"/>
                                </xsl:attribute>
                                <xsl:attribute name="unidad">
                                    <xsl:value-of select="ram/@unidad"/>
                                </xsl:attribute>
                            </ram>
                        </portatil>
                    </xsl:if>
                </xsl:for-each>
                <!--Este bucle recorre los tablets-->
                <xsl:for-each select="pedido/tablets/tablet">
                    <xsl:if test="precio &lt; 500">
                        <tablet>
                            <xsl:attribute name="precio">
                                <xsl:value-of select="precio"/>
                            </xsl:attribute>
                            <plataforma><xsl:value-of select="plataforma"/></plataforma>
                            <caracteristicas>
                                <memoria>
                                    <xsl:attribute name="cantidad">
                                        <xsl:value-of select="caracteristicas/memoria"/>
                                    </xsl:attribute>
                                    <xsl:attribute name="unidad">
                                        <xsl:value-of select="caracteristicas/memoria/@medida"/>
                                    </xsl:attribute>
                                </memoria>
                            </caracteristicas>
                        </tablet>
                    </xsl:if>
                </xsl:for-each>
            </baratos>
        </pedido>
    </xsl:template>
</xsl:stylesheet>