package br.com.rodpk.gamelist.model;

import org.hibernate.annotations.GenericGenerator;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter @Setter
@NoArgsConstructor
@Table(name = "files")
public class File {
    
    @Id @Column(name = "file_id")     
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String id;
    
    @Column(name = "name")
    private String name;

    @Column(name = "content_type")
    private String contentType;
    
    @Column(name = "size")
    private long size;

    @Lob
    @Column(name = "data")
    private byte[] data;
    
}
