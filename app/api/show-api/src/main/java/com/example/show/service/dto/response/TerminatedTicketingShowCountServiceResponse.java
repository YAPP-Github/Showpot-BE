package com.example.show.service.dto.response;

public record TerminatedTicketingShowCountServiceResponse(
    long count
) {
    public static TerminatedTicketingShowCountServiceResponse noCount() {
        return new TerminatedTicketingShowCountServiceResponse(0);
    }

    public static TerminatedTicketingShowCountServiceResponse from(long count) {
        return new TerminatedTicketingShowCountServiceResponse(count);
    }
}
