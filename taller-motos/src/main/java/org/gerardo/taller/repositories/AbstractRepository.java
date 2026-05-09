package org.gerardo.taller.repositories;

import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;

import java.util.List;

public abstract class AbstractRepository<T> implements CrudRepository<T> {

    @Inject
    protected EntityManager em; // protected para que las clases hijas puedan usarlo si necesitan consultas personalizadas

    private final Class<T> entityClass; // Aquí guardaremos si es Marca.class, Cliente.class, etc.

    // El constructor obliga a las clases hijas a decirnos de qué tipo son
    protected AbstractRepository(Class<T> entityClass) {
        this.entityClass = entityClass;
    }

    @Override
    public void guardar(T entidad) {
        try {
            em.getTransaction().begin();
            // Para saber si es nuevo o actualización, JPA nos permite verificar si el objeto ya está en el contexto
            // Como estamos usando genéricos, no podemos hacer entidad.getId(), así que usamos merge directamente
            // (Merge inserta si no existe, o actualiza si ya existe)
            em.merge(entidad);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            e.printStackTrace();
        }
    }

    @Override
    public T buscarPorId(Integer id) {
        return em.find(entityClass, id); // Aquí usamos la variable que inyectamos en el constructor
    }

    @Override
    public List<T> listarTodos() {
        // Armamos el JPQL dinámicamente usando el nombre de la clase
        String jpql = "SELECT e FROM " + entityClass.getSimpleName() + " e";
        return em.createQuery(jpql, entityClass).getResultList();
    }

    @Override
    public void eliminar(Integer id) {
        try {
            em.getTransaction().begin();
            T entidad = buscarPorId(id);
            if (entidad != null) {
                em.remove(entidad);
            }
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            e.printStackTrace();
        }
    }

}
