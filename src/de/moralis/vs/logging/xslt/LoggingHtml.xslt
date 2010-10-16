<?xml version="1.0" encoding="iso-8859-1"?>
<xsl:stylesheet version="2.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform" xmlns:moralis="http://www.moralis.de"
                xmlns:fn="http://www.w3.org/2005/xpath-functions" xmlns:xs="http://www.w3.org/2001/XMLSchema">
    <xsl:output method="xml" doctype-system="http://www.w3.org/TR/xhtml11/DTD/xhtml11.dtd" indent="yes"/>

    <xsl:param name="logName"/>

    <xsl:variable name="line" select="1" as="xs:integer"/>

    <xsl:template match="/">
        <html>
            <head>
                <title>
                    <xsl:value-of select="$logName"/>
                </title>
                <link rel="stylesheet" type="text/css" href="css\log.css"/>
            </head>
            <body>
                <div class="body">
                    <h2>
                        <xsl:value-of select="$logName"/>
                    </h2>
                    <table cellspacing="0">
                        <xsl:apply-templates/>
                    </table>
                </div>
            </body>
        </html>
    </xsl:template>

    <xsl:template match="record">
        <tr class="{lower-case(level)}">
            <td>
                <xsl:value-of disable-output-escaping="yes" select="fn:replace(message, '\n', '&lt;br /&gt;')"/>
            </td>
        </tr>
    </xsl:template>
</xsl:stylesheet>
