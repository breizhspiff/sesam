package biz.meziant.model;

import org.hibernate.annotations.GenericGenerator;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * Created by ronan on 17/12/16.
 */
@Entity
@EntityListeners(AuditingEntityListener.class)
public class Event {

    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid2")
    private String id;

    @CreatedDate
    private Date createdDate = new GregorianCalendar().getTime();

    @Column
    @Enumerated(EnumType.STRING)
    private Source source;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Source getSource() {
        return source;
    }

    public void setSource(Source source) {
        this.source = source;
    }

    public Date getCreatedDate() {
        return createdDate;
    }
}
