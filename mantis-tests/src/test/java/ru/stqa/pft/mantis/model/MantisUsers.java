package ru.stqa.pft.mantis.model;

import com.google.common.collect.ForwardingSet;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public class MantisUsers extends ForwardingSet<MantisUserData> {

  private Set<MantisUserData> delegate;

  public MantisUsers (MantisUsers mantisUsers) {
    this.delegate = new HashSet<MantisUserData>(mantisUsers.delegate);
  }

  public MantisUsers(){
    this.delegate = new HashSet<MantisUserData>();
  }

  public MantisUsers(Collection<MantisUserData> mantisUsers) {
    this.delegate = new HashSet<MantisUserData>(mantisUsers);
  }

  @Override
  protected Set<MantisUserData> delegate() {
    return delegate;
  }



  }


