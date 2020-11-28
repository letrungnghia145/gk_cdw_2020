package application.config;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import application.model.Member;

public class WebappConfig {
	public List<Member> getMembers() {
		List<Member> members = new ArrayList<>();
		return members;
	}
}
