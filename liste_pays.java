Locale[] locales = Locale.getAvailableLocales();
StringBuilder builder = new StringBuilder("<string-array name=\"pays\">\n");
for (Locale locale : locales) {
    String country = locale.getDisplayCountry();
    if (country != null && !country.isEmpty()) {
        builder.append("    <item>").append(country).append("</item>\n");
    }
}
builder.append("</string-array>");
Log.d("XML_GENERATOR", builder.toString());