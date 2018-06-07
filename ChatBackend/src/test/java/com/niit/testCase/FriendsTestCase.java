package com.niit.testCase;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.DAO.FriendDAO;
import com.niit.model.Friends;
import com.niit.model.UserDetails;

public class FriendsTestCase {
static FriendDAO friendDAO;
	
    @BeforeClass
    public static void initialize()
    {
    	AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
    	context.scan("com.niit");
    	context.refresh();
    	
    	friendDAO=(FriendDAO)context.getBean("friendDAO");
    	
    }
    
    @Ignore
    @Test
    public void showFriendList()
    {
    	List<Friends> listFriend=friendDAO.viewFriendRequests("Deepi");
    	System.out.println("Loginname \t friendName \t status");
    	assertNotNull("Problem in listing friends",listFriend);
		

    	for(Friends friend:listFriend)
    	{
    		System.out.print(friend.getLoginname()+"\t\t");
    		System.out.print(friend.getFriendloginname()+"\t\t");
    		System.out.println(friend.getStatus());

    	}
    }
    
    @Ignore
    @Test
    public void sendFriendRequest()
    {
    	Friends friends=new Friends();
    	friends.setLoginname("Deepi");
    	friends.setFriendloginname("priya");
    	
    	
    	assertTrue("Problem in sending friend request", friendDAO.sendFriendRequest(friends));
    }
    
    @Ignore
    @Test
    public void acceptFriendRequest()
    {
    	assertTrue("Problem in accepting friend request", friendDAO.acceptFriendRequest(2050));
    }
    
    @Ignore
    @Test
    public void rejectFriendRequest()
    {
    	assertTrue("Problem in accepting friend request", friendDAO.deleteFriendRequest(2000));
    }
    

    @Ignore
    @Test
    public void SuggestedFriendRequest()
    {
    	List<UserDetails> listUserDetail=friendDAO.viewSuggestedFriendRequests("Kavi");
    	
    	assertTrue("Problem in listing Suggested Friend",listUserDetail.size()>0);
    	
    	for(UserDetails userDetail:listUserDetail)
    	{
    		System.out.println("Loginname: "+userDetail.getLoginname());
   
    	}
    	
    }
    
    
    @Test
	public void showPendingRequest()
	{
		List<Friends> listFriend=friendDAO.viewPendingFriendRequests("Deepi");
		System.out.println("Loginname \t friendName");
		assertNotNull("Problem in Listing Friend",listFriend);
		
		for(Friends friend:listFriend)
		{
			System.out.print(friend.getLoginname()+"\t\t");
			System.out.println(friend.getFriendloginname()+"\t\t");
		}
		
	}

    
	
}
