package de.de.lambdas.tophits;

public class Album {


    private Artist artist;
    private Integer sales;
    private String name;

    public Integer getSales() {
        return sales;
    }

    public Artist getArtist() {
        return artist;
    }

    public void setArtist(Artist artist) {
        this.artist = artist;
    }

    public void setSales(Integer sales) {
        this.sales = sales;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static class Builder {
        private String name;
        private Integer sales;
        private Artist artist;


        public Builder(String albumName) {
            this.name = albumName;

        }

        public Builder withArtist(Artist artist) {
            this.artist = artist;
            return this;

        }

        public Builder withSales(Integer sales) {
            this.sales = sales;
            return this;

        }

        public Album build() {
            Album album = new Album();
            album.setArtist(this.artist);
            album.setSales(this.sales);
            album.setName(this.name);
            return album;
        }

    }


}
