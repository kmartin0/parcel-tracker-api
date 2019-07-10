package com.km.parceltracker.features.parcelstatus;

import com.km.parceltracker.util.CacheUtils;
import lombok.Data;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Data
@Entity
@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.READ_WRITE, region = CacheUtils.PARCEL_STATUS_CACHE_REGION)
public class ParcelStatus {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false)
	@NotNull(groups = {Identifier.class})
	private Long id;

	@Basic
	@Column(name = "status", nullable = false, length = 45)
	@Enumerated(EnumType.STRING)
	private ParcelStatusEnum status;

	public interface Identifier {

	}
}
