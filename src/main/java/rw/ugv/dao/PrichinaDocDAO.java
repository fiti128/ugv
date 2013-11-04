package rw.ugv.dao;

import rw.ugv.dto.UgvPrichinaDoc;

import java.util.List;

/**
 * User: Siarhei Yanusheusky
 * Date: 24.10.13
 * Time: 14:41
 */
public interface PrichinaDocDAO {
    List<UgvPrichinaDoc> getPrichinaDocByKodForm(String kodForm);
}
