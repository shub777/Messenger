package org.shub.archetypes.messenger.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.shub.archetypes.messenger.database.DatabaseClass;
import org.shub.archetypes.messenger.models.Comment;
import org.shub.archetypes.messenger.models.ErrorMessage;
import org.shub.archetypes.messenger.models.Message;

public class CommentService {
	
	private Map<Long,Message> messages = DatabaseClass.getMessages();
	
	public List<Comment> getAllComments(long messageId){
		return new ArrayList<Comment>(messages.get(messageId).getComments().values());
	}

	public Comment getComment(long messageId,long commentId){
		ErrorMessage errorMessage = new ErrorMessage("NotFound",404,"This is getComment() exception.");
		Response response = Response.status(Status.NOT_FOUND)
				.entity(errorMessage)
				.build();
		Message message = messages.get(messageId);
		if(message == null){
			throw new WebApplicationException(response);
		}
		Map<Long,Comment> comments = messages.get(messageId).getComments();
		Comment comment = comments.get(commentId);
		if(comment == null){
			throw new WebApplicationException(response);
		}
		return comment;
	}
	
	public Comment addComment(long messageId,Comment comment){
		Map<Long,Comment> comments = messages.get(messageId).getComments();
		comment.setId(comments.size() + 1);
		comments.put(comment.getId(), comment);
		return comment;
	}
	
	public Comment updateComment(long messageId,Comment comment){
		Map<Long,Comment> comments = messages.get(messageId).getComments();
		if(comment.getId()<=0) return null;
		comments.put(messageId, comment);
		return comment;
	}
	
	public Comment removeComment(long messageId,long commentId){
		return messages.get(messageId).getComments().remove(commentId);
	}
}
