<?xml version="1.0" encoding="ISO-8859-1"?>
<xsl:stylesheet version="1.0"
	xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
	<xsl:output method="html" indent="no"></xsl:output>
	<xsl:template match="/">
		<xsl:param name="modelname"></xsl:param>

		<!-- This xsl file displays the details of the model selected by the user -->
		<html>
			<head>
				<title>Bike Reviews</title>
				<link rel="stylesheet" type="text/css"
					href="ACMEStylesheet.css"
					title="style" />
			</head>
			<body>

				<table align="center" border="1px solid black" bgcolor="#E0F0FF">
					<caption>
						Bike Reviews for
						<xsl:value-of select="$modelname" />
					</caption>
					<tr >
						<th align="left">Brand</th>
						<xsl:for-each select="bikelist/bike[model=$modelname]">
							<td>
								<xsl:choose>
									<xsl:when test="brand=''">
										Not Available
									</xsl:when>
									<xsl:otherwise>
										<xsl:value-of select="brand" />
									</xsl:otherwise>
								</xsl:choose>
							</td>

						</xsl:for-each>
					</tr>
					<tr >
						<th align="left">Model</th>
						<xsl:for-each select="bikelist/bike[model=$modelname]">
							<td>
								<xsl:choose>
									<xsl:when test="model=''">
										Not Available
									</xsl:when>
									<xsl:otherwise>
										<xsl:value-of select="model" />
									</xsl:otherwise>
								</xsl:choose>
							</td>
						</xsl:for-each>
					</tr>
					<tr >
						<th align="left">Fork material</th>
						<xsl:for-each select="bikelist/bike[model=$modelname]">
							<td>
								<xsl:choose>
									<xsl:when test="forkmaterial=''">
										Not Available
									</xsl:when>
									<xsl:otherwise>
										<xsl:value-of select="forkmaterial" />
									</xsl:otherwise>
								</xsl:choose>
							</td>
						</xsl:for-each>
					</tr>
					<tr >
						<th align="left">Frame Sizes</th>
						<xsl:for-each select="bikelist/bike[model=$modelname]">
							<td>
								<xsl:choose>
									<xsl:when test="framesize=''">
										Not Available
									</xsl:when>
									<xsl:otherwise>
										<xsl:value-of select="framesize" />
									</xsl:otherwise>
								</xsl:choose>
							</td>
						</xsl:for-each>
					</tr>
					<tr >
						<th align="left">Price</th>
						<xsl:for-each select="bikelist/bike[model=$modelname]">
							<td>
								<xsl:choose>
									<xsl:when test="price=''">
										Not Available
									</xsl:when>
									<xsl:otherwise>
										<xsl:value-of select="price" />
									</xsl:otherwise>
								</xsl:choose>
							</td>
						</xsl:for-each>
					</tr>
					<tr >
						<th align="left">Consumer Rating</th>
						<xsl:for-each select="bikelist/bike[model=$modelname]">
							<td>
								<xsl:choose>
									<xsl:when test="rating=''">
										Not Available
									</xsl:when>
									<xsl:otherwise>
										<xsl:value-of select="rating" />
									</xsl:otherwise>
								</xsl:choose>
							</td>
						</xsl:for-each>
					</tr>


					<!-- Display Component info -->
					<tr >
						<th align="left">Saddle</th>
						<xsl:for-each select="bikelist/bike[model=$modelname]/componentinfo">

							<td>
								<xsl:choose>
									<xsl:when test="saddle=''">
										Not Available
									</xsl:when>
									<xsl:otherwise>
										<xsl:value-of select="saddle" />
									</xsl:otherwise>
								</xsl:choose>
							</td>

						</xsl:for-each>
					</tr>
					<tr >
						<th align="left">Seatpost</th>
						<xsl:for-each select="bikelist/bike[model=$modelname]/componentinfo">
							<td>
								<xsl:choose>
									<xsl:when test="seatpost=''">
										Not Available
									</xsl:when>
									<xsl:otherwise>
										<xsl:value-of select="seatpost" />
									</xsl:otherwise>
								</xsl:choose>
							</td>
						</xsl:for-each>
					</tr>
					<tr >
						<th align="left">Handlebars</th>
						<xsl:for-each select="bikelist/bike[model=$modelname]">
							<td>
								<xsl:choose>
									<xsl:when test="componentinfo/handlebars=''">
										Not Available
									</xsl:when>
									<xsl:otherwise>
										<xsl:value-of select="componentinfo/handlebars" />
									</xsl:otherwise>
								</xsl:choose>
							</td>
						</xsl:for-each>
					</tr>
					<tr >
						<th align="left">Stem</th>
						<xsl:for-each select="bikelist/bike[model=$modelname]">
							<td>
								<xsl:choose>
									<xsl:when test="componentinfo/stem=''">
										Not Available
									</xsl:when>
									<xsl:otherwise>
										<xsl:value-of select="componentinfo/stem" />
									</xsl:otherwise>
								</xsl:choose>
							</td>
						</xsl:for-each>
					</tr>
					<tr >
						<th align="left">Headset</th>
						<xsl:for-each select="bikelist/bike[model=$modelname]">
							<td>
								<xsl:choose>
									<xsl:when test="componentinfo/headset=''">
										Not Available
									</xsl:when>
									<xsl:otherwise>
										<xsl:value-of select="componentinfo/headset" />
									</xsl:otherwise>
								</xsl:choose>
							</td>
						</xsl:for-each>
					</tr>
					<tr >
						<th align="left">Breakset</th>

						<xsl:for-each select="bikelist/bike[model=$modelname]">
							<td>
								<xsl:choose>
									<xsl:when test="componentinfo/brakeset=''">
										Not Available
									</xsl:when>
									<xsl:otherwise>
										<xsl:value-of select="componentinfo/brakeset" />
									</xsl:otherwise>
								</xsl:choose>
							</td>
						</xsl:for-each>
					</tr>
				</table>
			</body>
		</html>
	</xsl:template>
</xsl:stylesheet>