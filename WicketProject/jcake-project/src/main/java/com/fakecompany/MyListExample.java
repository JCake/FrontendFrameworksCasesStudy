package com.fakecompany;

import java.util.ArrayList;
import java.util.List;

import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.form.Button;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.ListView;
import org.apache.wicket.model.Model;
import org.apache.wicket.request.mapper.parameter.PageParameters;

public class MyListExample extends HomePage {

	public MyListExample(PageParameters parameters) {
		super(parameters);
		// TODO Add your page's components here:
		Form<String> form = new Form<String>("form");

		final List<String> listData = new ArrayList<String>();

		final TextField<String> textField = new TextField<String>("thing");
		textField.setModel(new Model<String>());
		form.add(textField);
		form.add(new Button("addThing"){
			private static final long serialVersionUID = 1L;
			
			@Override
			public void onSubmit(){
				listData.add(textField.getInput());
			}
			
		});
		
		form.add(new ListView<String>("listOfThings", listData)
			 {
				private static final long serialVersionUID = 1L;

					public void populateItem(final ListItem<String> item)
			        {
			                item.add(new Label("listThing", item.getModelObject()));
			                item.add(new Link<Object>("removeLink"){
								private static final long serialVersionUID = 1L;

								@Override
								public void onClick() {
									listData.remove(item.getIndex());
								}
			                });
			        }
			 });
		
		add(form);
	}
	

	
}
