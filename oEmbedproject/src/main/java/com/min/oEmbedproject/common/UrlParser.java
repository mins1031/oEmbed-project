package com.min.oEmbedproject.common;

public class UrlParser {

    private final static String instagramOembedUrl = new String("https://api.instagram.com/oembed?url=");
    private final static String youtubeOembedUrl = new String("https://www.youtube.com/oembed?url=");
    private final static String twitterOembedUrl = new String("https://publish.twitter.com/oembed?url=");
    private final static String vimeoOembedUrl = new String("https://vimeo.com/api/oembed.json?url=");
    private final static String contentFormat = "&format=json";

    public static StringBuffer MadeYoutubeOembedUrl(String searchUrl){
        StringBuffer completeYoutubeOembedUrl = new StringBuffer();
        completeYoutubeOembedUrl.insert(0,youtubeOembedUrl)
                .append(searchUrl).append(contentFormat);

        System.out.println("url= "+ completeYoutubeOembedUrl);

        return completeYoutubeOembedUrl;
    }

    public static StringBuffer MadeInstagramOembedUrl(String searchUrl){
        StringBuffer completeInstagramOembedUrl = new StringBuffer();
        completeInstagramOembedUrl.insert(0,instagramOembedUrl)
                .append(searchUrl).append(contentFormat);

        System.out.println("insta url=" +completeInstagramOembedUrl);
        System.out.println("insta url=" + instagramOembedUrl);

        return completeInstagramOembedUrl;
    }

    public static StringBuffer MadeTwitterOembedUrl(String searchUrl){
        StringBuffer completeTwitterOembedUrl = new StringBuffer();
        completeTwitterOembedUrl.insert(0,twitterOembedUrl)
                .append(searchUrl).append(contentFormat);

        System.out.println("twitter url=" + completeTwitterOembedUrl);
        System.out.println("twitter url=" + twitterOembedUrl);

        return completeTwitterOembedUrl;
    }

    public static StringBuffer MadeVimeoOembedUrl(String searchUrl){
        StringBuffer completeVimeoOembedUrl = new StringBuffer();
        completeVimeoOembedUrl.insert(0,vimeoOembedUrl).append(searchUrl);

        System.out.println(completeVimeoOembedUrl);
        System.out.println("vimeo url=" + vimeoOembedUrl);

        return completeVimeoOembedUrl;
    }
    //new 연산은 최대한 기피하고 싶지만 객체지향적으로 구현하기 위해 클래스로 나눔.

}
