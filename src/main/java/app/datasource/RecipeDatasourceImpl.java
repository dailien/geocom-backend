package app.datasource;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import app.recipe.Recipe;

@Repository
@Transactional
public class RecipeDatasourceImpl  implements RecipeDatasource {
    
	@Autowired
	private SessionFactory sessionFactory;

	@Override
    public List<Recipe> findAll() {
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Recipe.class);
		criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
		return (List<Recipe>)criteria.list();
    }
    	
}
