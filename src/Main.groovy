import groovy.xml.XmlSlurper

class gvar {
    //Global variables
    static final String ls = System.getProperty("line.separator")
    static final String yt_address = "https://www.youtube.com/"
    static final String yt_xml_address = "https://www.youtube.com/oembed?format=xml&url=https%3A%2F%2Fwww.youtube.com%2Fwatch%3Fv%3D"
}

static void main(String[] args) {

    //Get vars from settings.xml
    def settings = new XmlSlurper().parse("settings.xml")
    String channel_id = settings.channelID
    String videos = settings.videos
    String csv = settings.csv
    Integer videosNum = videos.toInteger()

    //TODO: Get video ids from channel

    def htmlFile = new File("html_output.html")

    //The following is test code
    MakeHTMLHeader(htmlFile, "Test")
    htmlFile.append("<p>" + gvar.ls)
    htmlFile.append(channel_id + gvar.ls)
    htmlFile.append(videosNum + gvar.ls)
    htmlFile.append(csv + gvar.ls)
    htmlFile.append("</p>" + gvar.ls)
    MakeHTMLFooter(htmlFile)

}
static void MakeHTMLHeader(File file, String title) {
    file.delete()
    file.createNewFile()
    file.append("<html lang=\"en\">" + gvar.ls + "<head>" + gvar.ls + "<title>" + title + "</title>" + gvar.ls + "</head>" + gvar.ls + "<body>" + gvar.ls)
}

static void MakeHTMLFooter(File file) {
    file.append("</body>" + gvar.ls + "</html>")
}

static void SlurpAndBuildVideoDetails(String ID) {

    def oembedXML = gvar.yt_xml_address + ID
    def videoDetails = new XmlSlurper().parse(oembedXML)


}