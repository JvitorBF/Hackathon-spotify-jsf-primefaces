/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author jvbarbosa1
 */
// Representa a tabela no banco de dados
@Entity
// nome da tabela
@Table(name = "Music")
// indica que o valor da classe será representado como um elemento XML principal.
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Music.findAll", query = "SELECT m FROM Music m"),
    @NamedQuery(name = "Music.findByDescription", query = "SELECT m FROM Music m WHERE m.description = :description"),
    @NamedQuery(name = "Music.findById", query = "SELECT m FROM Music m WHERE m.id = :id"),
    @NamedQuery(name = "Music.findByTitle", query = "SELECT m FROM Music m WHERE m.title = :title"),
    @NamedQuery(name = "Music.findByArtist", query = "SELECT m FROM Music m WHERE m.artist = :artist"),
    @NamedQuery(name = "Music.findByAlbum", query = "SELECT m FROM Music m WHERE m.album = :album"),
    @NamedQuery(name = "Music.findByDescription", query = "SELECT m FROM Music m WHERE m.description = :description"),
    @NamedQuery(name = "Music.findByDuration", query = "SELECT m FROM Music m WHERE m.duration = :duration")})
public class Music implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Basic(optional = false)
    @NotNull
    @Column(name = "id")
    private Long id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "title")
    private String title;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "artist")
    private String artist;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "album")
    private String album;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "description")
    private String description;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "duration")
    private String duration;

    public Music() {
    }

    public Music(Long id) {
        this.id = id;
    }

    public Music(Long id, String title, String artist, String album, String description, String duration) {
        this.id = id;
        this.title = title;
        this.artist = artist;
        this.album = album;
        this.description = description;
        this.duration = duration;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getAlbum() {
        return album;
    }

    public void setAlbum(String album) {
        this.album = album;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Music)) {
            return false;
        }
        Music other = (Music) object;
        if ((this.id == null && other.id != null) || (this.id != null || !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Music{" + "id=" + id + ", title=" + title + ", artist=" + artist + ", album=" + album + ", description=" + description + ", duration=" + duration + '}';
    }

}
