static void main(String[] args) {

    //Set variables to pull data from
    final String YT_ADDRESS = "https://www.youtube.com/"
    final String YT_VID_XML_PREFIX = "https://www.youtube.com/oembed?format=xml&url=https%3A%2F%2Fwww.youtube.com%2Fwatch%3Fv%3D"
    def htmlFile = new File("html_output.html")

    MakeHTMLHeader(htmlFile, "Test")
    MakeHTMLFooter(htmlFile)

}
static void MakeHTMLHeader(File file, String title) {
    //initialize file
    def ls = System.getProperty("line.separator")
    file.delete()
    file.createNewFile()
    file.append("<html>" + ls + "<head>" + ls + "<title>" + title + "</title>" + ls + "</head>" + ls + "<body>" + ls)
}

static void MakeHTMLFooter(File file) {
    //close file
    file.append("</body>" + System.getProperty("line.separator") + "</html>")
}
