package com.bean;

import javax.persistence.Column;

/*
列名	类型	长度	备注	关系
Id	int		歌曲编号	PK
music_name	varchar	12	歌曲名
Singer_id	int		歌手编号	FK-singers(id)
album_id	Int		专辑编号	FK-albums(id)
views	int		访问量
Download_type	int		下载次数
Views_total	int		总访问量
song_type	varchar	12	歌曲关键字
cover_image	vachar		封面图片
Address	varchar	20	歌曲地区
*/

public class Music {

    @Column(name = "id")
    private int Id;
    @Column(name = "music_name")
    private String musicName;
    @Column(name = "song_type")
    private String songType;
    @Column(name = "Singer_id")
    private int singerId;
    @Column(name = "album_id")
    private int albumId;
    @Column(name="views")
    private int views;
    @Column(name = "Download_time")
    private int downloadTime;
    @Column(name = "cover_image")
    private String imagePath;
    @Column(name = "address")
    private String address;
    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getMusicName() {
        return musicName;
    }

    public void setMusicName(String musicName) {
        this.musicName = musicName;
    }

    public String getSongType() {
        return songType;
    }

    public void setSongType(String songType) {
        this.songType = songType;
    }

    public int getSingerId() {
        return singerId;
    }

    public void setSingerId(int singerId) {
        this.singerId = singerId;
    }

    public int getAlbumId() {
        return albumId;
    }

    public void setAlbumId(int albumId) {
        this.albumId = albumId;
    }

    public int getViews() {
        return views;
    }

    public void setViews(int views) {
        this.views = views;
    }

    public int getDownloadTime() {
        return downloadTime;
    }

    public void setDownloadTime(int downloadTime) {
        this.downloadTime = downloadTime;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Music{" +
                "Id=" + Id +
                ", musicName='" + musicName + '\'' +
                ", songType='" + songType + '\'' +
                ", singerId=" + singerId +
                ", albumId=" + albumId +
                ", views=" + views +
                ", downloadTime=" + downloadTime +
                ", imagePath='" + imagePath + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
