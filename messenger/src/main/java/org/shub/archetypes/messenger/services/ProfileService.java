package org.shub.archetypes.messenger.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.shub.archetypes.messenger.database.DatabaseClass;
import org.shub.archetypes.messenger.models.Message;
import org.shub.archetypes.messenger.models.Profile;

public class ProfileService {

	private Map<String,Profile> profiles = DatabaseClass.getProfiles();
	
	public ProfileService(){
		profiles.put("shub1", new Profile(1L,"Shub","Shubham","Bhama"));
		profiles.put("shub2", new Profile(2L,"bhama","Shubham","Bhama"));
	}
	
	public List<Profile> getAllProfiles(){
		return new ArrayList<Profile>(profiles.values());
	}
	
	public Profile getProfile(String profileName){
		return profiles.get(profileName);
	}
	
	public Profile addProfile(Profile profile){
		profile.setId(profiles.size() + 1);
		profiles.put(profile.getProfileName(), profile);
		return profile;
	}
	
	public Profile removeProfile(String nameId){
		return profiles.remove(nameId);
	}
	
	public Profile updateProfile(Profile profile){
		if(profile.getProfileName().isEmpty()){
			return null;
		}
		profiles.put(profile.getProfileName(), profile);
		return profile;
	}
}
