package biz.meziant.repository;

import biz.meziant.model.Event;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by ronan on 17/12/16.
 */
public interface EventRepository extends CrudRepository<Event, String> {
}
